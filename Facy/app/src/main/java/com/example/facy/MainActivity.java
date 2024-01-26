package com.example.facy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textView;
    ImageView imageView;

    private final static int REQUEST_IMAGE_CAPTURE = 124;
    InputImage firebaseVision;
    FaceDetector visionFaceDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.cameraBtn);
        textView = findViewById(R.id.text1);
        imageView = findViewById(R.id.imageView);

        FirebaseApp.initializeApp(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFile();
            }
        });
        Toast.makeText(this,
                "App is started",
                Toast.LENGTH_LONG).show();
    }

    private void openFile() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this,
                    "Failed!",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");

        faceDetectionProcess(bitmap);
        Toast.makeText(this,
                "Success!",
                Toast.LENGTH_LONG).show();
    }

    private void faceDetectionProcess(Bitmap bitmap) {

        textView.setText("Processing Image ...");
        final StringBuilder builder = new StringBuilder();

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();

        InputImage image = InputImage.fromBitmap(bitmap, 0);
        FaceDetectorOptions highAccuracyOpt = new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                .enableTracking().build();

        FaceDetector detector = FaceDetection.getClient(highAccuracyOpt);

        Task<List<Face>> result = detector.process(image);
        result.addOnSuccessListener(new OnSuccessListener<List<Face>>() {
            @Override
            public void onSuccess(List<Face> faces) {
                if (faces.size() != 0) {
                    if (faces.size() == 1) {
                        builder.append(faces.size() + " Face Detected\n\n");
                    } else if (faces.size() > 1) {
                        builder.append(faces.size() + " Faces Detected\n\n");
                    }
                }

                for (Face face : faces) {
                    int id = face.getTrackingId();
                    float rotY = face.getHeadEulerAngleY();
                    float rotZ = face.getHeadEulerAngleZ();
                    builder.append("1. Face tracking ID [" + (id+1) + "]\n");
                    builder.append("2. Head rotation to right ["
                            + String.format("%.2f", rotY) + " deg.]\n");
                    builder.append("3. Head tilted sideways ["
                            + String.format("%.2f", rotZ) + " deg.]\n");

                    //Smiling probability
                    if(face.getSmilingProbability() >0){
                        float smilingProbability = face.getSmilingProbability();
                        builder.append("4. Smiling probability ["
                                + String.format("%.2f", smilingProbability) + "]\n");
                    }

                    //left eye opened
                    if(face.getLeftEyeOpenProbability() >0){
                        float leftEye = face.getLeftEyeOpenProbability();
                        builder.append("5. Left eye is open ["
                                + String.format("%.2f", leftEye) + "]\n");
                    }
                    //right eye opened
                    if(face.getRightEyeOpenProbability() >0){
                        float rightEye = face.getRightEyeOpenProbability();
                        builder.append("6. Right eye is open ["
                                + String.format("%.2f", rightEye) + "]\n");
                    }
                    builder.append("\n");

                }
                showDetection("Face Detection", builder, true);
            }
        });
        result.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Sorry! There is an error!");
                showDetection("Face Detection", builder, false);
            }
        });


    }

    //Show result of Firebase ML_kit detection in Textview
    private void showDetection(final String title, final StringBuilder builder, boolean success) {

        if(success == true){
            textView.setText(null);
            textView.setMovementMethod(new ScrollingMovementMethod());

            if (builder.length() != 0){
                textView.append(builder);
                if(title.substring(0, title.indexOf(' ')).equalsIgnoreCase("OCR")) {
                    textView.append("\n(Hold the text to copy it)");
                } else {
                    textView.append("(Hold the text to Copy it!)");
                }
                textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        ClipboardManager clipboard = (ClipboardManager)
                                getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText(title, builder);
                        clipboard.setPrimaryClip(clip);
                        return true;
                    }
                });
            } else {
                textView.append(title.substring(0, title.indexOf(' ')) + " Failed to find anything");
            }
        } else if (success == false) {
            textView.setText(null);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textView.append(builder);
        }

    }
}
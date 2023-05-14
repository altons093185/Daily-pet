package com.example.dailypet_0115;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class editpet extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private CircleImageView uploadimage;
    private ImageView upcamera;
    private Uri ImageUri = null;
    private Button cancel;
    private Button finish;
    private EditText addname;
    private EditText addkind;
    private EditText addbirth;
    private EditText addage;
    private String user_id;
    private boolean isChanged = false;
    String email;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private StorageReference storageReference;
    private FirebaseDatabase firebaseDatabase;
    private static final int REQUEST_WRITE_PERMISSION = 786;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpet);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();

        addname = (EditText) findViewById(R.id.addname);
        addkind = (EditText) findViewById(R.id.addkind);
        addbirth = (EditText) findViewById(R.id.addbirth);
        addage = (EditText) findViewById(R.id.addage);
        uploadimage = findViewById(R.id.uploadimage);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();

        user_id = firebaseAuth.getCurrentUser().getUid();

        cancel = findViewById(R.id.cancel);
        finish = findViewById(R.id.finish);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isChanged) {
                    String addName = addname.getText().toString();
                    String addKind = addkind.getText().toString();
                    String addBirth = addbirth.getText().toString();
                    String addAge = addage.getText().toString();

                    Map<String, String> petdata = new HashMap<>();

                    petdata.put("Petname", addName);
                    petdata.put("PetVariety", addKind);
                    petdata.put("PetBirthday", addBirth);
                    petdata.put("PetAge", addAge);
                    firebaseFirestore.collection("Pet").document(email).set(petdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void avoid) {
                            Toast.makeText(editpet.this, "修改成功!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(editpet.this, "failure", Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                }


                if (isChanged) {
                    user_id = firebaseAuth.getCurrentUser().getUid();
                    String addName = addname.getText().toString();
                    String addKind = addkind.getText().toString();
                    String addBirth = addbirth.getText().toString();
                    String addAge = addage.getText().toString();

                    Map<String, String> petdata = new HashMap<>();

                    petdata.put("Petname", addName);
                    petdata.put("PetVariety", addKind);
                    petdata.put("PetBirthday", addBirth);
                    petdata.put("PetAge", addAge);

//                    final String user_id = firebaseAuth.getCurrentUser().getUid();
                    final StorageReference image_path = storageReference.child("dog_profile_imag").child(user_id + ".jpg");

                    image_path.putFile(ImageUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }
                            return image_path.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri download_uri = task.getResult();
                                Map<String, String> usermap = new HashMap<>();
                                usermap.put("image", download_uri.toString());
                                firebaseFirestore.collection("PetPicture").document(email).set(usermap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Intent mintent = new Intent(editpet.this, createpet.class);
                                                    startActivity(mintent);
                                                    finish();
                                                } else {
                                                    String error = task.getException().getMessage();
                                                    Toast.makeText(editpet.this, "Error :" + error, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            }
                        }
                    });

                    firebaseFirestore.collection("Pet").document(email).set(petdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void avoid) {
                            Toast.makeText(editpet.this, "修改成功!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(editpet.this, "failure", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {

                    //finish();
                    //Toast.makeText(editpet.this, "請輸入資訊或上傳照片", Toast.LENGTH_SHORT).show();
                    //storeFirestore(null);
                }

            }
        });
        //uploadimage = findViewById(R.id.uploadimage);
        upcamera = (ImageButton) findViewById(R.id.upcamera);
        upcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
                //IF THE ANDROID SDK UP TO MARSMALLOW BUILD NUMBER
                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //START REQUEST PERMISSION
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
                } else {
                    //ELSE BELOW START OPEN PICKER
                    CropImage.startPickImageActivity(editpet.this);
                }*/
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //THIS IS HAPPEN WHEN USER CLICK ALLOW ON PERMISSION
            //START PICK IMAGE ACTIVITY
            CropImage.startPickImageActivity(editpet.this);
        }
    }

    @Override
    @SuppressLint("NewApi")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            ImageUri = CropImage.getPickImageResultUri(this, data);
            Log.i("RESPONSE getPath", ImageUri.getPath());
            Log.i("RESPONSE getScheme", ImageUri.getScheme());
            Log.i("RESPONSE PathSegments", ImageUri.getPathSegments().toString());

            //NOW CROP IMAGE URI
            CropImage.activity(ImageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setMultiTouchEnabled(true)
                    //REQUEST COMPRESS SIZE
                    .setRequestedSize(800, 800)
                    //ASPECT RATIO, DELETE IF YOU NEED CROP ANY SIZE
                    .setAspectRatio(1, 1)
                    .start(this);
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Log.i("RESPONSE getUri", result.getUri().toString());

                //GET CROPPED IMAGE URI AND PASS TO IMAGEVIEW
                uploadimage.setImageURI(result.getUri());
                isChanged = true;
            }
        }
    }

    private void storeFirestore(@NonNull Task<UploadTask.TaskSnapshot> task) {

        Uri download_uri;
        if (task != null) {
            download_uri = task.getResult().getUploadSessionUri();
        } else {
            download_uri = ImageUri;
        }
        Map<String, String> usermap = new HashMap<>();
        usermap.put("image", download_uri.toString());
        firebaseFirestore.collection("PetPicture").document(email).set(usermap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent mintent = new Intent(editpet.this, createpet.class);
                            startActivity(mintent);
                            finish();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(editpet.this, "Error :" + error, Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }


    private void openFileChooser() {
        //IF THE ANDROID SDK UP TO MARSMALLOW BUILD NUMBER
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //START REQUEST PERMISSION
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        } else {
            //ELSE BELOW START OPEN PICKER
            CropImage.startPickImageActivity(editpet.this);
        }
        /*Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);*/
    }

   /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

       /* super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            if(requestCode==RESULT_OK){
                ((CircleImageView) findViewById(R.id.uploadimage)).setImageURI(result.getUri());
                isChanged=true;
            }else if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    Exception error=result.getError();
            }
        }*/
       /*if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            ImageUri = data.getData();
            //Picasso.with(this).load(ImageUri).into(uploadimage);
            uploadimage.setImageURI(ImageUri);
            isChanged = true;
        }

    }*/


}

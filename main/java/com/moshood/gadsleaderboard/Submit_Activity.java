package com.moshood.gadsleaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.moshood.gadsleaderboard.R;
import com.moshood.gadsleaderboard.apis.PostService;
import com.moshood.gadsleaderboard.apis.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Submit_Activity extends AppCompatActivity {
    private PostService mPostService;
    private EditText mEdtFirstName;
    private EditText mEdtLastName;
    private EditText mEdtEmailAddress;
    private EditText mEdtGithubLink;
    private AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_vector_test);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mEdtFirstName = findViewById(R.id.edt_first_name);
        mEdtLastName = findViewById(R.id.edt_last_name);
        mEdtEmailAddress = findViewById(R.id.edt_email_address);
        mEdtGithubLink = findViewById(R.id.edt_github_link);
    }

    public void submitProject(View view){

        final View customLayout = getLayoutInflater().inflate(R.layout.confirmation_message, null);
        MaterialAlertDialogBuilder builder1 = new MaterialAlertDialogBuilder(this, R.style.MyRounded_MaterialComponents_MaterialAlertDialog);
        builder1/setView(customLayout);
        builder1/setCancelable(false);

        mDialog = builder1.create();
        mDialog.show();
    }

    public  void submitOnline(View view) {
        mDialog.cancel();
        String firstName = mEdtFirstName.getText().toString();
        String lastName = mEdtLastName.getText().toString();
        String emailAddress = mEdtEmailAddress.getText().toString();
        String githubLink = mEdtGithubLink.getText().toString();
        mPostService = RetrofitClientInstance.getRetrofitInstanceToPost().create(PostService.class);
        mPostService.updateUser(firstName, lastName, emailAddress, githubLink).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.i("SubmitActivity", "post submitted to API.");
                    showDialog2();
    }
}

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("PostActivity", "Unable to submit post to API.");
                showDialog3();
            }
        });

    }

    public void closeDialog(View view) {
        mDialog.cancel();
    }

    public void showDialog2() {

        final View customLayout = getLayoutInflater().inflate(R.layout.submission_succesful, null);
        MaterialAlertDialogBuilder builder1 = new MaterialAlertDialogBuilder(this, R.style.MyRounded_MaterialComponents_MaterialAlertDialog);
        builder1.setView(customLayout);
        builder1.setCancelable(true);
        AlertDialog dialog = builder1.create();
        dialog.show();
    }

    public void showDialog3() {

        final View customLayout = getLayoutInflater().inflate(R.layout.submit_unsuccessful, null);
        MaterialAlertDialogBuilder builder1 = new MaterialAlertDialogBuilder(this, R.style.MyRounded_MaterialComponents_MaterialAlertDialog);
        builder1.setView(customLayout);
        builder1.setCancelable(true);
        AlertDialog dialog = builder1.create();
        dialog.show();
    }
}
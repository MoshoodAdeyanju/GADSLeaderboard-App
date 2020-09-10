package com.moshood.gadsleaderboard.apis;

import com.moshood.gadsleaderboard.models.IqLeader;
import com.moshood.gadsleaderboard.models.TopLearner;

import java.util.List;

import retrofit2.Call;
;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/hours")
    Call<List<TopLearner>> getTopLearnersList();


    @GET("/api/skilliq")
    Call<List<IqLeader>> getIqLeadersList();

}

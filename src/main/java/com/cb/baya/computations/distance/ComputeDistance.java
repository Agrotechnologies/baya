package com.cb.baya.computations.distance;

import com.cb.baya.common.ApiConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;

import java.io.IOException;

public class ComputeDistance {
    private String[] origins, destinations;

    public ComputeDistance(String[] origins, String[] destinations) {
        this.origins = origins;
        this.destinations = destinations;
    }

    /**
     * This function should compute distance between given coordinates
     * @return Distance Matrix Object
     * @throws InterruptedException
     * @throws ApiException
     * @throws IOException
     */
    // TODO revise return value from string to object or gson
    // TODO Add Google Maps API KEY in ApiConstants
    public String compute() throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(ApiConstants.GOOGLE_MAPS_API_KEY)
                .build();

        DistanceMatrix distanceMatrix=DistanceMatrixApi.getDistanceMatrix(context,origins,destinations).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(distanceMatrix.rows);
    }
}

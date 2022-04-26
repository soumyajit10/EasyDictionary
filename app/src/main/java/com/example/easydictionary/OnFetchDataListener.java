package com.example.easydictionary;

import com.example.easydictionary.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse,String message);
    void OnError(String message);
}

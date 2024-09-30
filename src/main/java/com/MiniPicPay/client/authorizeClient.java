package com.MiniPicPay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authorizeClient", url = "https://run.mocky.io")
public interface authorizeClient {

	@GetMapping("/v3/959ca019-afc8-44b6-adb6-523741afaf4c")
    Response getAuthorize();
}

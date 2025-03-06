package com.java.service;

import com.java.dto.ApproveResponseDto;
import com.java.dto.OrderDto;
import com.java.dto.ReadyResponseDto;

public interface KakaopayService {

	ReadyResponseDto payReady(OrderDto odto);

	ApproveResponseDto payApprove(String tid, String pgToken);

}

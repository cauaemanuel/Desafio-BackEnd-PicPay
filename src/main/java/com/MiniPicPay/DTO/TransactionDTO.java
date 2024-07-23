package com.MiniPicPay.DTO;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderid, Long receiver) {

}

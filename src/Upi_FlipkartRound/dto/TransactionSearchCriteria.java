package Upi_FlipkartRound.dto;

import Upi_FlipkartRound.Models.TransactionStatus;

import java.time.LocalDateTime;

public record TransactionSearchCriteria(
        LocalDateTime startDate,
        LocalDateTime endDate,
        TransactionStatus status,
        String userId
) {


}

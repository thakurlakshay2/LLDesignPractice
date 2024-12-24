package FlipkartRound1.dto;

import FlipkartRound1.Models.TransactionStatus;

import java.time.LocalDateTime;

public record TransactionSearchCriteria(
        LocalDateTime startDate,
        LocalDateTime endDate,
        TransactionStatus status,
        String userId
) {


}

package LockerManagementSystem.Strategy;

public class OtpGeneratorRandom implements IOtpGenerator{
    private final int otpLength;
    private final IRandomGenerator randomGenerator;

    public OtpGeneratorRandom(int otpLength, IRandomGenerator randomGenerator) {
        this.otpLength = otpLength;
        this.randomGenerator = randomGenerator;

    }

    @Override
    public String generateOtp() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<otpLength;i++){
            sb.append(randomGenerator.getRandomNumber(10));
        }
        return sb.toString();
    }
}

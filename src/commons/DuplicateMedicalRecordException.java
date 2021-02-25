package commons;

public class DuplicateMedicalRecordException extends Exception {
    public DuplicateMedicalRecordException() {
    }

    @Override
    public String getMessage() {
        return "MÃ BỆNH ÁN ĐÃ TỒN TẠI.";
    }
}

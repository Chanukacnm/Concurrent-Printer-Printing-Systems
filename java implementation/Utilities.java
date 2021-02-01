class Utilities {
    //alert messages
    final static String PRINTING_REQUEST_RECEIVED = "--- PRINTING REQUEST RECEIVED ---";
    final static String WAITING_FOR_PRINTING_RESOURCES = "--- WAITING FOR PRINTING RESOURCES ---";
    final static String PRINTING_DOC_DONE = "--- DOCUMENT PRINTING DONE ---";
    final static String ENOUGH_PRINTING_RESOURCES = "--- ENOUGH PRINTING RESOURCES | OUT OF WAIT LOOP ---";
    final static String WAITING_FOR_PAPER_REQUEST = "--- ENOUGH PAPER DETECTED | WAITING FOR REFILL REQUEST ---";
    final static String WAITING_FOR_TONER_REQUEST = "--- ENOUGH TONER DETECTED | WAITING FOR REFILL REQUEST ---";
    final static String STUDENT_OUT = "--- STUDENT OUT ---";
    final static String TONER_REPLACE_REQUEST_RECEIVED = "--- TONER REPLACE REQUEST RECEIVED ---";
    final static String TONER_REPLACING = "--- REPLACE TONER ---";
    final static String TONER_REPLACE_DONE = "--- TONER REPLACE DONE ---";
    final static String TONER_REPLACE_REQUEST_PROCESSED = "--- TONER REPLACE REQUEST PROCESSED ---";
    final static String PAPER_REPLACE_REQUEST_RECEIVED = "--- PAPER REPLACE REQUEST RECEIVED ---";
    final static String PAPER_REPLACING = "--- REPLACING PAPER ---";
    final static String PAPER_REPLACE_DONE = "--- PAPER REPLACE DONE ---";
    final static String PAPER_REPLACE_REQUEST_PROCESSED = "--- PAPER REPLACE REQUEST PROCESSED ---";

    static int timeRandomizer() {
        int seconds = (int) (Math.random() * 1000);

        System.out.println("TIMES : " + seconds);
        return seconds;
    }
}

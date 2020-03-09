public class CricketLeagueAnalyserException extends RuntimeException {

        public CricketLeagueAnalyserException(ExceptionType type) {
            this.type=type;
        }

        enum ExceptionType {
            IPL_FILE_PROBLEM,UNABLE_TO_PARSE,NO_IPL_DATA,INVALID_TYPE_IN_IPL;
        }
        ExceptionType type;
        public CricketLeagueAnalyserException(String message, ExceptionType type) {
            super(message);
            this.type = type;
        }

        public CricketLeagueAnalyserException(String message, ExceptionType type, Throwable cause) {
            super(message, cause);
            this.type = type;
        }
    }


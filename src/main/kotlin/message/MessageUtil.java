package message;

public class MessageUtil {

  private static final String commandMenuMessage = """
      1. 계산
      2. 조회
      0. 종료
      입력 : """;

  public static String getCommandMenuMessage() {
    return commandMenuMessage;
  }
}

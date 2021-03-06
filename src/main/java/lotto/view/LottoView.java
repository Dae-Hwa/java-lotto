package lotto.view;

import java.util.Map;
import lotto.model.Lottos;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class LottoView {

  public static void printPurchaseRequestMsg() {
    System.out.println("구입 금액을 입력해주세요");
  }

  public static void printPurchaseDoneMsg(int quantity) {
    System.out.println(quantity + "개를 구매했습니다.");
  }

  public static void printLottoNumbers(Lottos lottos) {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottos.getLottoList()) {
      sb.append(lotto.toString()).append("\n");
    }
    System.out.println(sb);
  }

  public static void printWinningNumberRequestMsg() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void printWinningBonusNumberRequestMsg() {
    System.out.println("보너스 볼을 입력해 주세요.");
  }

  public static void printStatisticsMsg() {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
  }

  public static void printPrizeTierCnt(Map<PrizeTier, Integer> prizeTierCntMap) {
    prizeTierCntMap.entrySet().stream()
        .filter(e -> 3 <= e.getKey().getMatchCnt().getValue())
        .forEach(e -> {
          System.out.printf("%s (%d원) - %d개\n",
              e.getKey().getMatchCnt().toString(),
              e.getKey().getPrize(),
              prizeTierCntMap.get(e.getKey()));
        });
  }

  public static void printProfitRate(double profit) {
    System.out.println(getProfitRateMessage(profit));
  }

  private static String getProfitRateMessage(double profit) {
    if (profit < 1) {
      return "총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    } else if (profit == 1) {
      return "총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    } else {
      return "총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    }
  }

}

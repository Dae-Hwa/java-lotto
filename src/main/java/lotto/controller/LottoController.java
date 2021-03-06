package lotto.controller;

import java.util.Scanner;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.LottoFactory;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.view.LottoView;

public class LottoController {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    LottoView.printPurchaseRequestMsg();

    Lottos lottos = LottoFactory.createLottosByQuickPick(new Money(scanner.nextInt()));
    scanner.nextLine();

    LottoView.printPurchaseDoneMsg(lottos.getLottoList().size());

    LottoView.printLottoNumbers(lottos);

    LottoView.printWinningNumberRequestMsg();
    String[] winningNumberArr = scanner.nextLine().split(",");

    LottoView.printWinningBonusNumberRequestMsg();

    LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());

    WinningLotto winningLotto = WinningLotto.newInstanceByStrArr(winningNumberArr, bonusNumber);

    LottoView.printStatisticsMsg();

    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lottos, winningLotto);

    LottoView.printPrizeTierCnt(winningStatistics.getPrizeTierCntMap());

    LottoView.printProfitRate(winningStatistics.getProfitRate());
  }
}

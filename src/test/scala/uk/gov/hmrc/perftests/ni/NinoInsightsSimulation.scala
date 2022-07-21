package uk.gov.hmrc.perftests.ni

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.ni.InsightsRequests.checkWatchList

class NinoInsightsSimulation extends PerformanceTestRunner {

  setup("check-watch-list", "Check Watch List") withRequests checkWatchList

  runSimulation()
}

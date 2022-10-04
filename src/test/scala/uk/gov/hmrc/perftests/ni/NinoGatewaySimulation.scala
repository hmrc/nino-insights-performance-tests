package uk.gov.hmrc.perftests.ni

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.ni.GatewayRequests.checkWatchListViaGateway

class NinoGatewaySimulation extends PerformanceTestRunner {

  setup("check-watch-list-gateway", "Check Watch List via Gateway") withRequests checkWatchListViaGateway

  runSimulation()
}

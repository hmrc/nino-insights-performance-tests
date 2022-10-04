package uk.gov.hmrc.perftests.ni

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.ni.GatewayRequests.checkWatchListViaGateway
import uk.gov.hmrc.perftests.ni.InsightsRequests.checkInsightsWatchListDirectly

class NinoInsightsSimulation extends PerformanceTestRunner {

  setup("check-watch-list-gateway", "Check Watch List via Gateway") withRequests checkWatchListViaGateway

  setup("check-watch-list-direct", "Check Watch List directly") withRequests checkInsightsWatchListDirectly

  runSimulation()
}

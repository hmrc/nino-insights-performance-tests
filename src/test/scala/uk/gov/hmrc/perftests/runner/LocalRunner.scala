package uk.gov.hmrc.perftests.runner
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import uk.gov.hmrc.perftests.ni.NinoInsightsSimulation

object LocalRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[NinoInsightsSimulation].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}

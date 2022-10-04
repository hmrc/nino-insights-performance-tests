package uk.gov.hmrc.perftests.ni

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object GatewayRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("nino-gateway")
  val route: String   = "/nino-gateway"

  val checkWatchListViaGateway: HttpRequestBuilder =
    http("Check if account is on watch list")
      .post(s"$baseUrl$route/check/insights")
      .header(HttpHeaderNames.ContentType, "application/json")
      .body(StringBody("""|{
                          |  "nino": "${nino}"
                          |}
                          |""".stripMargin))
      .asJson
      .check(status.is(200))
      .check(jsonPath("$.riskScore").is("${riskScore}"))
      .check(jsonPath("$.reason").is("${reason}"))
}

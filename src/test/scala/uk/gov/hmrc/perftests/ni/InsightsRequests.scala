/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.ni

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object InsightsRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("nino-insights")
  val route: String   = "/nino-insights"

  val checkInsightsWatchListDirectly: HttpRequestBuilder =
    http("Check if account is on watch list")
      .post(s"$baseUrl$route/check/insights")
      .header(HttpHeaderNames.ContentType, "application/json")
      .header(HttpHeaderNames.Authorization, "QGYkpEia-0Ll1sbyTBFvhFnIE8TlKBeilrICrcngwJtTM4Emc52Hl6XpCQBaCYBOCuzkunWfn")
      .body(StringBody("""|{
                          |  "nino": "${nino}"
                          |}
                          |""".stripMargin))
      .asJson
      .check(status.is(200))
      .check(jsonPath("$.riskScore").is("${riskScore}"))
      .check(jsonPath("$.reason").is("${reason}"))
}

package com.example

import example.com.module
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

/**
 * 编写集成测试
 * https://ktor.io/docs/server-create-a-new-project.html#write-an-integration-test
 * @author Ak
 * 2024/7/18 17:02
 */
class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        val response = client.get("/")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello World!", response.bodyAsText())
        assertContains(response.bodyAsText(), "Hello From Ktor")
    }
}
package com.example.versioning.controller

import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@Unroll
class VersionControllerSpec extends Specification {

    def 'Controller returns correct response for version by Url'() {
        given:
        def controller = new VersionController()
        MockMvc mockMvc = standaloneSetup(controller).build()

        when:
        def response = mockMvc.perform(get(url)).andReturn().response

        then:
        response.status == 200
        response.getContentAsString() == bodyText

        where:
        url               | bodyText
        "/api/v1/version" | "v1 by Url"
        "/api/v2/version" | "v2 by Url"
    }

    def 'Controller returns correct response for version by content type'() {
        given:
        def controller = new VersionController()
        MockMvc mockMvc = standaloneSetup(controller).build()

        when:
        def response = mockMvc.perform(get(url).header("Accept", header)).andReturn().response

        then:
        response.status == 200
        response.getContentAsString() == bodyText


        where:
        url            | bodyText            | header
        "/api/version" | "v1 by ContentType" | "application/v1"
        "/api/version" | "v2 by ContentType" | "application/v2"
    }
}
package org.example.helpdesk;

import org.example.utils.BaseSeleniumTest;
import org.example.utils.ConfigProvider;
import org.example.utils.TestValues;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void testHelpDesk() {
        String title = TestValues.TEST_TITLE;
        TicketPage ticketPage = new MainPage().createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .authenticate(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);
        assertNotNull(ticketPage);
    }
}
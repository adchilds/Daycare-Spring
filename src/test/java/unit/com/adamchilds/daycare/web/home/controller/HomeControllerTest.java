package unit.com.adamchilds.daycare.web.home.controller;

import com.adamchilds.daycare.entity.account.service.AccountService;
import com.adamchilds.daycare.entity.subscription.service.SubscriptionService;
import com.adamchilds.daycare.entity.user.service.UserService;
import com.adamchilds.daycare.web.home.controller.impl.HomeControllerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for the {@link com.adamchilds.daycare.web.home.controller.HomeController} class.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(
        locations = {
                "classpath*:/com/adamchilds/daycare/springconfig/applicationContext-test-homeController.xml"
        }
)
@WebAppConfiguration
public class HomeControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);

    @Mock
    private AccountService accountService;
    @Mock
    private SubscriptionService subscriptionService;
    @Mock
    private UserService userService;

    @InjectMocks
    private HomeControllerImpl homeController;

    private MockMvc mockMvc;

    private static final String HOMEPAGE_URI_EMPTY = "/";
    private static final String HOMEPAGE_URI_INDEX = "/index.html";
    private static final String INDEX_PAGE_TILES_NAME = "index";

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testGetIndexPage() {
        try {
            mockMvc.perform(get(HOMEPAGE_URI_EMPTY))
                    .andExpect(status().isOk())
                    .andExpect(view().name(INDEX_PAGE_TILES_NAME));

            mockMvc.perform(get(HOMEPAGE_URI_INDEX))
                    .andExpect(status().isOk())
                    .andExpect(view().name(INDEX_PAGE_TILES_NAME));
        } catch(Exception e) {
            logger.error("Could not perform test GET requests to HomeController", e);

            fail();
        }
    }

}
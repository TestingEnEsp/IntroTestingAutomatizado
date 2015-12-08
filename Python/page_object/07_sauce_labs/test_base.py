import unittest
from selenium import webdriver


class BaseTestCase(unittest.TestCase):

    # Estos datos deben ser extraidos de nuestra cuenta en SauceLabs
    SAUCE_USERNAME = ''
    SAUCE_KEY = ''

    def setUp(self):
        sauce_url = "http://" + self.SAUCE_USERNAME + ":" + self.SAUCE_KEY +"@ondemand.saucelabs.com:80/wd/hub"

        desired_capabilities = {'platform': "Mac OS X 10.9",
                                'browserName': "chrome",
                                'version': "31",
                                }

        self.driver = webdriver.Remote(desired_capabilities=desired_capabilities, command_executor=sauce_url)
        self.driver.get("http://www.mercadolibre.com.ar/")
        self.driver.maximize_window()

    def tearDown(self):
        self.driver.quit()

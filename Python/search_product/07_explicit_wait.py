from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
import unittest

# Vemos como funciona el explicit wait

class ExplicitWaitTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()
        self.driver.get("http://www.mercadolibre.com.ar/")

    def test_suggestions(self):
        # Creamos el WebElement Search Field
        search_field = self.driver.find_element_by_id("query")
        search_field.send_keys("tele")
        suggestions = WebDriverWait(self.driver, 10).until(expected_conditions.visibility_of_element_located((By.ID, "ac-popover-2")))
        suggestions.find_element_by_class_name("ac-autocomplete-item").click()

    def tearDown(self):
        self.driver.quit()

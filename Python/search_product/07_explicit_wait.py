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
        self.driver.get("http://demo.magentocommerce.com/")

    def test_account_link(self):
        # Capturamos el elemento account cuando se cumple la condicion de que esta visible
        account = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.visibility_of_element_located((By.CLASS_NAME, "skip-account")))
        account.click()

    def test_create_new_customer(self):
        # Hacemos click en Account para habilitar el link de Login
        self.driver.find_element_by_class_name("skip-account").click()

        # Esperamos por el link y le hacemos click
        my_account = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.visibility_of_element_located((By.CSS_SELECTOR, "#header-account .first a")))
        my_account.click()

        # Capturamos el webelement Create account
        create_account_button = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.element_to_be_clickable((By.CSS_SELECTOR, ".button[title='Create an Account']")))

        # Hacemos click y esperamos por el titulo de la pantalla
        create_account_button.click()
        WebDriverWait(self.driver, 10)\
            .until(expected_conditions.title_contains("Create New Customer Account"))

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main(verbosity=2)

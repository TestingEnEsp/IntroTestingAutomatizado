import unittest
from selenium import webdriver

# Vemos ejemplos donde el Implicit Wait no nos va a servir 
# y cuando si

class SearchTests(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

        # definimos el el implicit wait
        self.driver.implicitly_wait(30)

    def test_hello(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://the-internet.herokuapp.com/dynamic_loading/1")

        # Creamos el WebElement start
        self.start = self.driver.find_element_by_tag_name("button")

        # Hacemos click en Start
        self.start.click()

        # Validamos que se muestre el mensaje Hello World
        self.assertTrue(self.driver.find_element_by_id("finish").is_displayed(),
                        "Hello world no fue encontrado!")

    def test_hello2(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://the-internet.herokuapp.com/dynamic_loading/2")

        # Creamos el WebElement start
        self.start = self.driver.find_element_by_tag_name("button")

        # Hacemos click en Start
        self.start.click()

        # Validamos que se muestre el mensaje Hello World
        self.assertTrue(self.driver.find_element_by_id("finish").is_displayed(),
                        "Hello world no fue encontrado!")

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()

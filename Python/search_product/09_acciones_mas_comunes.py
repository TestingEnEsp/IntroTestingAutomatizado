import unittest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
import datetime
import time
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.support.ui import Select


class DistintasAcciones(unittest.TestCase):
    def setUp(self):
        # Instanciar Firefox
        self.driver = webdriver.Firefox()

        # definimos el tiempo de espera por default
        self.driver.implicitly_wait(30)

        # maximizamos la pantalla
        self.driver.maximize_window()

    def test_drag_and_drop(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://jqueryui.com/resources/demos/droppable/default.html")

        # localizamos el elemento a arrastrar
        source = self.driver.find_element_by_id("draggable")

        # localizamos el lugar a donde lo queremos arrastrar
        target = self.driver.find_element_by_id("droppable")

        # ejecutamos las acciones de arrastrar y soltar
        ActionChains(self.driver).drag_and_drop(source, target).perform()

        self.assertEqual("Dropped!", target.text)

    def test_dropdown_selection(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://the-internet.herokuapp.com/dropdown")

        select = Select(self.driver.find_element_by_id("dropdown"))

        select.select_by_visible_text("Option 2")

    def test_double_click(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://api.jquery.com/dblclick/")
        frame = self.driver.find_element_by_tag_name("iframe")
        self.driver.switch_to.frame(frame)
        box = self.driver.find_element_by_tag_name("div")

        # verify color is Blue
        self.assertEqual("rgba(0, 0, 255, 1)",
                         box.value_of_css_property("background-color"))

        ActionChains(self.driver).\
            move_to_element(self.driver.find_element_by_tag_name("span"))\
            .perform()
        ActionChains(self.driver).double_click(box).perform()

        # verify Color is Yellow
        self.assertEqual("rgba(255, 255, 0, 1)",
                         box.value_of_css_property("background-color"))

    def test_tool_tip(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://jqueryui.com/tooltip/")

        driver = self.driver
        frame_elm = driver.find_element_by_class_name("demo-frame")
        driver.switch_to.frame(frame_elm)

        age_field = driver.find_element_by_id("age")
        ActionChains(self.driver).move_to_element(age_field).perform()

        tool_tip_elm = WebDriverWait(self.driver, 10)\
            .until(expected_conditions.visibility_of_element_located((By.CLASS_NAME, "ui-tooltip-content")))

        # verificamos el mensaje
        self.assertEqual("We ask for your age only for statistical purposes.", tool_tip_elm.text)

    def test_window_popup(self):
        driver = self.driver
        driver.get("http://the-internet.herokuapp.com/windows")

        # Guardamos el nombre de la ventana actual para poder volver
        parent_window_id = driver.current_window_handle

        # Abrimos una nueva ventana
        link = driver.find_element_by_link_text("Click Here")
        link.click()
        driver.switch_to.window(driver.window_handles[-1])
        driver.close()
        driver.switch_to.window(parent_window_id)

    def test_alerts(self):
        driver = self.driver
        driver.get("http://the-internet.herokuapp.com/javascript_alerts")

        # Hacemos click en el boton para JS Alert
        driver.find_elements_by_tag_name("button")[0].click()

        # ponemos el foco en el alert
        js_alert = driver.switch_to.alert

        # aceptamos el mensaje del popup
        js_alert.accept()
        # en caso de que tenga accept / cancel, lo podemos cancelar
        # con js_alert.dismiss()

        # verificamos el resultado
        self.assertEqual("You successfuly clicked an alert", driver.find_element_by_id("result").text)

    def test_screen_shot(self):
        # Navegamos hasta la aplicacion
        self.driver.get("http://www.mercadolibre.com.ar/")
        driver = self.driver
        try:
            promo_banner_elem = driver.find_element_by_id("promo_banner")
            self.assertEqual("Promotions", promo_banner_elem.text)
        except NoSuchElementException:
            st = datetime.datetime\
                .fromtimestamp(time.time()).strftime('%Y%m%d_%H%M%S')
            file_name = "main_page_missing_banner" + st + ".png"
            driver.save_screenshot(file_name)
            raise

    def tearDown(self):
        # Cerramos el navegador
        self.driver.quit()

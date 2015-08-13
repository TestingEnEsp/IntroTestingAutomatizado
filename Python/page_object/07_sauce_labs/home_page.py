from search_page import SearchPage
from page_base import BasePage

class HomePage(BasePage):

    def navigate_to(self):
        self._driver.get(self._url)

    def search_for(self, keyword):
        search_field = self._driver.find_element_by_id("search")
        search_field.send_keys(keyword)
        search_field.submit()

        return SearchPage(self._driver)

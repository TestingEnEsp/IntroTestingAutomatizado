from search_page import SearchPage
from page_base import BasePage


class HomePage (BasePage):

    def search_for(self, keyword):
        search_field = self._driver.find_element_by_id("query")
        search_field.send_keys(keyword)
        search_field.submit()

        return SearchPage(self._driver)

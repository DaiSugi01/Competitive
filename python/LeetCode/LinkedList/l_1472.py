from typing import List

class BrowserHistory:
    cache: List[str]
    f: List[str]

    def __init__(self, homepage: str):
        self.cache = [homepage]
        self.f = []

    def visit(self, url: str) -> None:
        self.cache.append(url)
        self.f = []

    def back(self, steps: int) -> str:
        while steps > 0 and len(self.cache) > 1:
            self.f.append(self.cache.pop())
            steps -= 1

        return self.cache[0] if steps > 0 else self.cache[len(self.cache) - 1]

    def forward(self, steps: int) -> str:
        while len(self.f) > 0 and steps > 0:
            self.cache.append(self.f.pop())
            steps -= 1

        return self.cache[len(self.cache) - 1]

# https://leetcode.com/problems/reformat-date/
def reformatDate(self, date: str) -> str:
    d = {
        "Jan": "01",
        "Feb": "02",
        "Mar": "03",
        "Apr": "04",
        "May": "05",
        "Jun": "06",
        "Jul": "07",
        "Aug": "08",
        "Sep": "09",
        "Oct": "10",
        "Nov": "11",
        "Dec": "12",
    }
    is_two_digit = len(date) >= 13
    year = date[-4:]
    if len(date) >= 13:
        month = d[date[5:-5]]
        day = date[0:2]
    else:
        month = d[date[4:-5]]
        day = "0" + date[0:1]

    return year + '-' + month + '-' + day
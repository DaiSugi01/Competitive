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
    day, month, year = date.split(' ')
    month = d[month]
    day = day[len(day) // 2]
    day = day if len(day) > 1 else '0' + day

    return year + '-' + month + '-' + day
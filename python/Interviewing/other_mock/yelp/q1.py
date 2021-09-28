def sol(topics, reviews):
    is_seen = {}
    for topic in topics:
        is_seen[topic] = [False] * len(reviews)

    res = {}
    for topic, keywords in topics.items():
        res[topic] = 0
        for keyword in keywords:
            for i, review in enumerate(reviews):
                if is_seen[topic][i]:
                    continue

                if keyword.lower() in review.lower():
                    is_seen[topic][i] = True
                    res[topic] += 1

    return res


if __name__ == '__main__':
    topics = {
        "Meat": ["chicken", "beef", "pork"],
        "Vegie": ["broccolli", "cabbage", "celery"],
        "Taste": ["sweet", "sour", "spicy"],
        "Japanese Specialty": ["bento", "tempura", "katsu", "karaage"],
        "American Specialty": ["burger", "hot dog", "donut"]
    }
    reviews = [
        "As someone who enjoys spicy food, I didn't think it was that spicy (They sprinkle some ground pepper flakes on top). The curry was nice and thick, but wasn't fillled with a lot of solids, mostly liquified potato, from what I could tell. The flavor was really nice, and the warmth really satisfying especially on the cold day that I ate this on.",
        "Got the katsu chicken curry. the curry has rich flavours and good fried chicken,",
        "I've heard of the name just a couple times so once I saw it, immediately I ordered their Katsu Curry ($9 + tax) a bag will cost you $.25",
        "This truck comes to our"
    ]
    # topics = {
    #     "Price": ["cheap", "expensive", "price"],
    #     "Business specialities": ["gnome", "gnomes"],
    #     "Harry Shrub": ["harry shrub"]
    # }
    # reviews = [
    #     "Harry Shrub did a great job with my garden, but I expected more gnomes for the price.",
    #     "I love my new gnomes, they are so cute! My dog loves them too! Thanks Harry!",
    #     "Very expensive at fifty dollars per gnome. Next time I'll buy from Cheap Gnomes Warehouse."
    # ]
    print(sol(topics, reviews))
# "Business specialities": 3,
# "Price": 2,
# "Harry Shrub": 1

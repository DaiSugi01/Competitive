def find_max_session(arrival, duration):
    arr_dur_pair = []
    for a, d in zip(arrival, duration):
        arr_dur_pair.append((int(a), int(d), int(a)+int(d)))

    arr_dur_pair = sorted(arr_dur_pair, key=lambda x: x[2])
    session_cnt = 1
    end_time = arr_dur_pair[0][2]

    for i in range(1, len(arr_dur_pair)):
        if arr_dur_pair[i][0] >= end_time:
            session_cnt += 1
            end_time = arr_dur_pair[i][2]

    return session_cnt


if __name__ == '__main__':
    print(find_max_session(['', '3', '3', '4', '5', '7'], ['2', '1', '2', '1', '2', '1']))

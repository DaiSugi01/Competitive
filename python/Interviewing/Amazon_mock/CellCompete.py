from copy import deepcopy

def cell_compete(states: [int], days: int) -> [int]:
    n = len(states)
    states = [0, *states, 0]
    new_states: [int] = deepcopy(states)

    for i in range(days):
        states = deepcopy(new_states)
        for j in range(1, n+1):
            if states[j - 1] == states[j + 1]:
                new_states[j] = 0
            else:
                new_states[j] = 1

    return new_states[1:n+1]

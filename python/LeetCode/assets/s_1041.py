import numpy as np
import matplotlib.pyplot as plt


def build(instructions: str, repeat: int):
    # up, right, down, left
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    # initial position is in the center, facing up
    x = y = idx = 0
    output_x = [0]
    output_y = [0]
    for _ in range(repeat):
        for i in instructions:
            if i == "G":
                x += directions[idx][0]
                y += directions[idx][1]
                output_x.append(x)
                output_y.append(y)
            elif i == "L":
                idx = (idx + 3) % 4
            elif i == "R":
                idx = (idx + 1) % 4
    return output_x, output_y


def plot_build(s: str, repeat: int):
    x, y = build(s, repeat)

    u = np.diff(x)
    v = np.diff(y)
    pos_x = x[:-1] + u / 2
    pos_y = y[:-1] + v / 2
    norm = np.sqrt(u ** 2 + v ** 2)

    plt.quiver(pos_x, pos_y, u / norm, v / norm, pivot='tail', color='black')
    plt.plot(x, y, marker="o", color='r')
    plt.xticks(x)
    plt.yticks(y)
    plt.ylim(top=max(y) + 1.5)
    plt.annotate("string = \"{}\", cycles = {}".format(s, repeat), (min(x), max(y) + 1))
    plt.show()


if __name__ == '__main__':
    plot_build("GRGL", 4)
    plot_build("GGGLGLGLGGL", 3)
    plot_build("GGGLGLGLGG", 4)
    plot_build("GRGGLL", 4)
    plot_build("GGGRGLGL", 4)

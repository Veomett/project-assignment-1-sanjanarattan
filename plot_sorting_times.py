import matplotlib.pyplot as plt


selection_sort_times = []
bubble_sort_times = []
insertion_sort_times = []
merge_sort_times = []
quick_sort_times = []

with open('sorting_data.txt', 'r') as file:
    lines = file.readlines()

for line in lines:
    if "Selection Sort" in line:
        time = line.split(',')[-1].strip()
        selection_sort_times.append(int(time))
    elif "Bubble Sort" in line:
        time = line.split(',')[-1].strip()
        bubble_sort_times.append(int(time))
    elif "Insertion Sort" in line:
        time = line.split(',')[-1].strip()
        insertion_sort_times.append(int(time))
    elif "Merge Sort" in line:
        time = line.split(',')[-1].strip()
        merge_sort_times.append(int(time))
    elif "Quick Sort" in line:
        time = line.split(',')[-1].strip()
        quick_sort_times.append(int(time))

array_sizes = [50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000]


plt.figure(figsize=(20, 12))
plt.plot(array_sizes, selection_sort_times, label='Selection Sort', marker='o')
plt.plot(array_sizes, bubble_sort_times, label='Bubble Sort', marker='o')
plt.plot(array_sizes, insertion_sort_times, label='Insertion Sort', marker='o')
plt.plot(array_sizes, merge_sort_times, label='Merge Sort', marker='o')
plt.plot(array_sizes, quick_sort_times, label='Quick Sort', marker='o')
plt.xlabel('Array Size')
plt.ylabel('Time (milliseconds)')
plt.title('Sorting Algorithm Performance (All Algorithms)')
plt.legend()
plt.grid(True)
plt.savefig('all_algorithms_performance.png')

plt.figure(figsize=(20, 12))
plt.plot(array_sizes, selection_sort_times, label='Selection Sort', marker='o')
plt.plot(array_sizes, bubble_sort_times, label='Bubble Sort', marker='o')
plt.plot(array_sizes, insertion_sort_times, label='Insertion Sort', marker='o')
plt.xlabel('Array Size')
plt.ylabel('Time (milliseconds)')
plt.title('Sorting Algorithm Performance (Selection, Bubble, Insertion)')
plt.legend()
plt.grid(True)
plt.savefig('n_squared_algorithms_performance.png')

plt.figure(figsize=(20, 12))
plt.plot(array_sizes, merge_sort_times, label='Merge Sort', marker='o')
plt.plot(array_sizes, quick_sort_times, label='Quick Sort', marker='o')
plt.xlabel('Array Size')
plt.ylabel('Time (milliseconds)')
plt.title('Sorting Algorithm Performance (Merge, Quick)')
plt.legend()
plt.grid(True)
plt.savefig('n_log_n_algorithms_performance.png')

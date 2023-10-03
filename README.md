#Project Assignment 1

SortingAlgorithms.java measures the exact time it takes for different sorting algorithms to sort different size arrays. Graphs of these can be found in the Jupyter Notebook, the .png files, or below.
![all_algorithms_performance](https://github.com/Veomett/project-assignment-1-sanjanarattan/assets/123421542/1981e91c-ddd5-4244-adbb-8b53db81f60a)


In addition, the code was run on VS code, which arguably tends to run slower than a pc's terminal, and below are the bare minimum, the basics necessity specs of the device this code was run on (my pc da best) :

![image](https://github.com/Veomett/project-assignment-1-sanjanarattan/assets/123421542/7a8443a6-1ecd-448b-a8aa-9c9cb2363668)


QuickerThanQuicksort.java combines quicksort and selection sort. Of the quadratic sorts, I chose selection sort because its really simple to implement and performs well on smaller arrays because it lacks complicated factors like multiple swaps (cough bubble sort). Insertion sort would be my second pick, but I did not choose it because I do not like the while loop (my brain prefers the skeleton of selection sort) and bubble sort my last pick because that was the slowest of the quadratic sorts. I chose a threshold of 20 because there is no positive value of n where n^2<nlogn. A value like 20 or below is efficient because if we take worse case scenarios I personally would want a worse case scenario of no more than 400 ms. At 20, the worse case for selection and quiksort are around this runtime, and beyond this value we can only hope and pray the pivot we choose allows for a best case scenario with quicksort. Either way, worse case for both sorts is the same.

package ru.nsu.ccfit.sazonova.threadpool;
import java.util.*;
/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class ThreadPool implements TaskListener {
   private static int threadCount;
   private List taskQueue = new LinkedList();
   private Set availableThreads = new HashSet();
   ThreadGroup threadGroup = new ThreadGroup("myGroup");

    public int getCountOfRunnableThread(){
        int n=0;
        for (Iterator iterator = availableThreads.iterator(); iterator.hasNext();)
            if(((Thread)iterator.next()).getState()== Thread.State.RUNNABLE)
                n++;
        return n;
    }

    public int getTaskQueueSize() {
        return taskQueue.size();
    }

    public void taskStarted(Task t)
   {
      System.out.println("Started:" + t.getName());
   }
   public void taskFinished(Task t)
   {
      System.out.println("Finished:" + t.getName());
   }
   public void taskInterrupted(Task t)
   {
      System.out.println("Interrupted:" + t.getName());
   }

   public void addTask(Task t)
   {
      addTask(t, this);
   }

   public void addTask(Task t, TaskListener l)
   {
      synchronized ( taskQueue )
      {
         taskQueue.add( new ThreadPoolTask(t, l) );
         taskQueue.notify();
      }
   }

   public ThreadPool(int _threadCount) {
       threadCount =_threadCount;

      for (int i=0; i<threadCount; i++)
      {
         PooledThread pt =  new PooledThread("Performer "+i,taskQueue, threadGroup);
         availableThreads.add(pt);
      }
      for (Iterator iter = availableThreads.iterator(); iter.hasNext(); )
      {
         ((Thread)iter.next()).start();
      }

   }
}
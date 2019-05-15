//process having same arrival time
//non preemptive mode
//process number
//arrival time
//burst time
//completion time //from grantt chart
//turn around time //ct - at
//waiting time = tat-bt
//gantt chart
import java.io.*;
class Process
{
	String processId;
	int bt,ct,tat,wt;
	void setProcessId (String processId)
	{
		this.processId = processId;
	}
	void setBt (int bt)
	{
		this.bt = bt;
	}
	String getProcessId ()
	{
		return processId;
	}
	int getBt ()
	{
		return bt;
	}
}



class fcfsSameArrivalTime
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		System.out.println ("Enter number of process");
		int n = Integer.parseInt(br.readLine());
		
		Process []processes = new Process[n];

		//taking input of data from user
		for (int i=0;i<n;++i)
		{
		System.out.println ("Enter Process id, its burst time for a process");
		processes[i] = new Process();
		String processId = br.readLine();
		int bt = Integer.parseInt(br.readLine());
		processes[i].setProcessId(processId) ;
		processes[i].setBt(bt);
		
		}


		//sorting on process id
		for (int i=0;i<processes.length-1;++i)
		{
			for (int j=0;j<processes.length-1;++j)
			{
				if (processes[j].processId.compareTo(processes[j+1].processId) > 0)
				{
					Process p = processes[j];
					processes[j] = processes[j+1];
					processes[j+1] = p;
				}
			}
		}



		int executionTime = 0;
		for (int i=0;i<n;++i)
		{
			executionTime += processes[i].bt;
			processes[i].ct = executionTime;
			processes[i].tat = processes[i].ct ;//- processes[i].at;
			processes[i].wt = processes[i].tat - processes[i].bt;
		}

		System.out.println ("Table is drawn below");
		System.out.println ("Process id \t AT \t BT \t\t CT \t\t TAT \t\t WT");
		for (int i=0;i<n;++i)
		{
			System.out.println (processes[i].processId + " \t\t " + "0" + " \t " + processes[i].bt + " \t\t " + processes[i].ct + " \t\t " + processes[i].tat + " \t\t " + processes[i].wt);
		}


	}
}
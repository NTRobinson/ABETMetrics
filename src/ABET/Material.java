package ABET;

public class Material 
{ // a graded material that satisfies ABET criteria
	private String name; // name of material/assignment
	
	private float sum_a_knowledge, sum_b_knowledge, sum_c_knowledge, sum_d_knowledge, sum_e_knowledge,
	sum_f_knowledge, sum_g_knowledge, sum_h_knowledge, sum_i_knowledge, sum_j_knowledge, sum_k_knowledge; // ABET criteria value for this material
	
	public Material(String n)
	{
		name = n;
		setSum_a_knowledge(0); // knowledge
		setSum_b_knowledge(0); // experience
		setSum_c_knowledge(0); // design
		setSum_d_knowledge(0); // teams
		setSum_e_knowledge(0); // formulate
		setSum_f_knowledge(0); // ethics
		setSum_g_knowledge(0); // communication
		setSum_h_knowledge(0); // global
		setSum_i_knowledge(0); // LLL
		setSum_j_knowledge(0); // cont.
		setSum_k_knowledge(0); // tools
	}
	
	public void print()
	{
		System.out.println(name);
		System.out.println("Sum A: " + sum_a_knowledge);
		System.out.println("Sum B: " + sum_b_knowledge);
		System.out.println("Sum C: " + sum_c_knowledge);
		System.out.println("Sum D: " + sum_d_knowledge);
		System.out.println("Sum E: " + sum_e_knowledge);
		System.out.println("Sum F: " + sum_f_knowledge);
		System.out.println("Sum G: " + sum_g_knowledge);
		System.out.println("Sum H: " + sum_h_knowledge);
		System.out.println("Sum I: " + sum_i_knowledge);
		System.out.println("Sum J: " + sum_j_knowledge);
		System.out.println("Sum K: " + sum_k_knowledge);
	}
	
	public String getName() {
		return name;
	}
	
	public float getSum_a_knowledge() {
		return sum_a_knowledge;
	}

	public void setSum_a_knowledge(float sum_a_knowledge) {
		this.sum_a_knowledge = sum_a_knowledge;
	}

	public float getSum_b_knowledge() {
		return sum_b_knowledge;
	}

	public void setSum_b_knowledge(float sum_b_knowledge) {
		this.sum_b_knowledge = sum_b_knowledge;
	}

	public float getSum_c_knowledge() {
		return sum_c_knowledge;
	}

	public void setSum_c_knowledge(float sum_c_knowledge) {
		this.sum_c_knowledge = sum_c_knowledge;
	}

	public float getSum_d_knowledge() {
		return sum_d_knowledge;
	}

	public void setSum_d_knowledge(float sum_d_knowledge) {
		this.sum_d_knowledge = sum_d_knowledge;
	}

	public float getSum_e_knowledge() {
		return sum_e_knowledge;
	}

	public void setSum_e_knowledge(float sum_e_knowledge) {
		this.sum_e_knowledge = sum_e_knowledge;
	}

	public float getSum_f_knowledge() {
		return sum_f_knowledge;
	}

	public void setSum_f_knowledge(float sum_f_knowledge) {
		this.sum_f_knowledge = sum_f_knowledge;
	}

	public float getSum_g_knowledge() {
		return sum_g_knowledge;
	}

	public void setSum_g_knowledge(float sum_g_knowledge) {
		this.sum_g_knowledge = sum_g_knowledge;
	}

	public float getSum_h_knowledge() {
		return sum_h_knowledge;
	}

	public void setSum_h_knowledge(float sum_h_knowledge) {
		this.sum_h_knowledge = sum_h_knowledge;
	}

	public float getSum_i_knowledge() {
		return sum_i_knowledge;
	}

	public void setSum_i_knowledge(float sum_i_knowledge) {
		this.sum_i_knowledge = sum_i_knowledge;
	}

	public float getSum_j_knowledge() {
		return sum_j_knowledge;
	}

	public void setSum_j_knowledge(float sum_j_knowledge) {
		this.sum_j_knowledge = sum_j_knowledge;
	}

	public float getSum_k_knowledge() {
		return sum_k_knowledge;
	}

	public void setSum_k_knowledge(float sum_k_knowledge) {
		this.sum_k_knowledge = sum_k_knowledge;
	}
}

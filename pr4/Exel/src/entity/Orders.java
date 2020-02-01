package entity;

public class Orders {
	private int id_order;
	private int id_user;
	private String login_user;
	private int id_room;
	private String type;
	private int kol_mest;
	private String data_ot;
	private String data_do;
	private double cost;
	private String status;
	private String pay;
	private String del_status;
	
	public Orders(int id_order, int id_user, String login_user, int id_room, String type, int kol_mest, String data_ot,
			String data_do, double cost, String status, String pay, String del_status) {
		this.id_order = id_order;
		this.id_user = id_user;
		this.login_user = login_user;
		this.id_room = id_room;
		this.type = type;
		this.kol_mest = kol_mest;
		this.data_ot = data_ot;
		this.data_do = data_do;
		this.cost = cost;
		this.status = status;
		this.pay = pay;
		this.del_status = del_status;
	}
	
	public Orders(int id_order) {
		this.id_order = id_order;
		
	}

	public Orders() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((data_do == null) ? 0 : data_do.hashCode());
		result = prime * result + ((data_ot == null) ? 0 : data_ot.hashCode());
		result = prime * result + ((del_status == null) ? 0 : del_status.hashCode());
		result = prime * result + id_order;
		result = prime * result + id_room;
		result = prime * result + id_user;
		result = prime * result + kol_mest;
		result = prime * result + ((login_user == null) ? 0 : login_user.hashCode());
		result = prime * result + ((pay == null) ? 0 : pay.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (data_do == null) {
			if (other.data_do != null)
				return false;
		} else if (!data_do.equals(other.data_do))
			return false;
		if (data_ot == null) {
			if (other.data_ot != null)
				return false;
		} else if (!data_ot.equals(other.data_ot))
			return false;
		if (del_status == null) {
			if (other.del_status != null)
				return false;
		} else if (!del_status.equals(other.del_status))
			return false;
		if (id_order != other.id_order)
			return false;
		if (id_room != other.id_room)
			return false;
		if (id_user != other.id_user)
			return false;
		if (kol_mest != other.kol_mest)
			return false;
		if (login_user == null) {
			if (other.login_user != null)
				return false;
		} else if (!login_user.equals(other.login_user))
			return false;
		if (pay == null) {
			if (other.pay != null)
				return false;
		} else if (!pay.equals(other.pay))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id_order=" + id_order + ", id_user=" + id_user + ", login_user=" + login_user + ", id_room="
				+ id_room + ", type=" + type + ", kol_mest=" + kol_mest + ", data_ot=" + data_ot + ", data_do="
				+ data_do + ", cost=" + cost + ", status=" + status + ", pay=" + pay + ", del_status=" + del_status
				+ "]";
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getLogin_user() {
		return login_user;
	}

	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getKol_mest() {
		return kol_mest;
	}

	public void setKol_mest(int kol_mest) {
		this.kol_mest = kol_mest;
	}

	public String getData_ot() {
		return data_ot;
	}

	public void setData_ot(String data_ot) {
		this.data_ot = data_ot;
	}

	public String getData_do() {
		return data_do;
	}

	public void setData_do(String data_do) {
		this.data_do = data_do;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getDel_status() {
		return del_status;
	}

	public void setDel_status(String del_status) {
		this.del_status = del_status;
	}
	
	
	
	
}

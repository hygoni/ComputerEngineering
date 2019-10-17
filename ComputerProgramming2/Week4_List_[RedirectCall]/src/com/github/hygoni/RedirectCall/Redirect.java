package com.github.hygoni.RedirectCall;

public class Redirect {
	private String from;
	private String to;

	public Redirect(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public boolean isFrom(String from) {
		return this.from.equals(from);
	}

	public String getTo() {
		return to;
	}

	public String toString() {
		return String.format("%s->%s", from, to);
	}

	public static boolean isFrom(Object data, String from) {
		if(data instanceof Redirect) {
			Redirect redir = (Redirect) data;
			return redir.from.equals(from);
		} else {
			return false;
		}
	}

	public static String getTo(Object data) {
		if(data instanceof Redirect) {
			Redirect redir = (Redirect) data;
			return redir.to;
		} else {
			return null;
		}
	}
}


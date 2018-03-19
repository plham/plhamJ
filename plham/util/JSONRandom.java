package plham.util;

import java.io.Serializable;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * JSONRandom extends RandomHelper to provide integrated usability with JSON.
 */

@SuppressWarnings("unused")
public class JSONRandom extends RandomHelper implements Serializable {
	private static final long serialVersionUID = -5097886776046142670L;

	/*
		public def this(random:Random) {
			super(random);
		}
	 */
	public JSONRandom(Random random) {
		super(random);
	}

	/*
		public def nextRandom(json:JSON.Value):Double {
			if (json.isList()) {
				assert json.size() == 2 : "Uniform distribution must be [min, max] but " + JSON.dump(json);
				val min = json(0).toDouble();
				val max = json(1).toDouble();
				return this.nextUniform(min, max);
			}
			if (json.isMap()) {
				assert json.size() == 1 : "Multiple speficiation of distribution type: " + JSON.dump(json);
				if (json.has("const")) {
					val args = json("const");
					assert args.size() == 1 : "Constant must be [value] but " + JSON.dump(json);
					val value = args(0).toDouble();
					return value;
				}
				if (json.has("uniform")) {
					val args = json("uniform");
					assert args.size() == 2 : "Uniform distribution must be [min, max] but " + JSON.dump(json);
					val min = args(0).toDouble();
					val max = args(1).toDouble();
					return this.nextUniform(min, max);
				}
				if (json.has("normal")) {
					val args = json("normal");
					assert args.size() == 2 : "Normal distribution must be [mu, sigma] but " + JSON.dump(json);
					val mu = args(0).toDouble();
					val sigma = args(1).toDouble();
					return this.nextNormal(mu, sigma);
				}
				if (json.has("expon")) {
					val args = json("expon");
					assert args.size() == 1 : "Exponential distribution must be [lambda] but " + JSON.dump(json);
					val lambda = args(0).toDouble();
					return this.nextExponential(lambda);
				}
				assert false : "Unknown distribution type: " + JSON.dump(json);
			}
			return json.toDouble(); // WARN: CONSTANT
		}
	 */

	public double nextRandom(JsonNode jsonNode) {
		if (jsonNode.isArray()) {
			assert jsonNode.size() == 2 : "Uniform distribution must be [min, max] but "
					+ jsonNode.toString();
			double min = jsonNode.get(0).asDouble();
			double max = jsonNode.get(1).asDouble();
			return nextUniform(min, max);
		}

		// TODO : データを見ること
		/*
		if (json.isMap()) {
			assert json.size() == 1 : "Multiple speficiation of distribution type: "
					+ JSON.dump(json);
			if (json.has("const")) {
				val args = json("const");
				assert args.size() == 1 : "Constant must be [value] but "
						+ JSON.dump(json);
				val value = args(0).toDouble();
				return value;
			}
			if (json.has("uniform")) {
				val args = json("uniform");
				assert args.size() == 2 : "Uniform distribution must be [min, max] but "
						+ JSON.dump(json);
				val min = args(0).toDouble();
				val max = args(1).toDouble();
				return this.nextUniform(min, max);
			}
			if (json.has("normal")) {
				val args = json("normal");
				assert args.size() == 2 : "Normal distribution must be [mu, sigma] but "
						+ JSON.dump(json);
				val mu = args(0).toDouble();
				val sigma = args(1).toDouble();
				return this.nextNormal(mu, sigma);
			}
			if (json.has("expon")) {
				val args = json("expon");
				assert args.size() == 1 : "Exponential distribution must be [lambda] but "
						+ JSON.dump(json);
				val lambda = args(0).toDouble();
				return this.nextExponential(lambda);
			}
			assert false : "Unknown distribution type: " + JSON.dump(json);
		}
		*/
		return jsonNode.asDouble(); // WARN: CONSTANT
	}
}

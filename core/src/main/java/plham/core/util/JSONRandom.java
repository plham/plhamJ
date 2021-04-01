package plham.core.util;

import java.io.Serializable;

import cassia.util.JSON;

/**
 * JSONRandom extends RandomHelper to provide integrated usability with JSON.
 */

@SuppressWarnings("unused")
public class JSONRandom extends RandomHelper implements Serializable {
	private static final long serialVersionUID = -5097886776046142670L;

	public JSONRandom(Random random) {
		super(random);
	}

	public double nextRandom(JSON.Value json) {
		if (json.isList()) {
			assert json.size() == 2 : "Uniform distribution must be [min, max] but " + JSON.dump(json);
			double min = json.get(0).toDouble();
			double max = json.get(1).toDouble();
			return nextUniform(min, max);
		}
		if (json.isMap()) {
			assert json.size() == 1 : "Multiple speficiation of distribution type: " + JSON.dump(json);
			if (json.has("const")) {
				JSON.Value args = json.get("const");
				assert args.size() == 1 : "Constant must be [value] but " + JSON.dump(json);
				double value = args.get(0).toDouble();
				return value;
			}
			if (json.has("uniform")) {
				JSON.Value args = json.get("uniform");
				assert args.size() == 2 : "Uniform distribution must be [min, max] but " + JSON.dump(json);
				double min = args.get(0).toDouble();
				double max = args.get(1).toDouble();
				return nextUniform(min, max);
			}
			if (json.has("normal")) {
				JSON.Value args = json.get("normal");
				assert args.size() == 2 : "Normal distribution must be [mu, sigma] but " + JSON.dump(json);
				double mu = args.get(0).toDouble();
				double sigma = args.get(1).toDouble();
				return nextNormal(mu, sigma);
			}
			if (json.has("expon")) {
				JSON.Value args = json.get("expon");
				assert args.size() == 1 : "Exponential distribution must be [lambda] but " + JSON.dump(json);
				double lambda = args.get(0).toDouble();
				return nextExponential(lambda);
			}
			assert false : "Unknown distribution type: " + JSON.dump(json);
		}
		return json.toDouble(); // WARN: CONSTANT

	}
}

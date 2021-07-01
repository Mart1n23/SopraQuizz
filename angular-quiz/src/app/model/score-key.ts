import { Quiz } from './quiz';
import { Personne } from './../personne';

export class ScoreKey {
  constructor(
    private _personne: Personne | any =null,
    private _quiz: Quiz | any =null
  ) {}


    /**
     * Getter personne
     * @return {Personne }
     */
	public get personne(): Personne  {
		return this._personne;
	}

    /**
     * Getter quiz
     * @return {Quiz }
     */
	public get quiz(): Quiz  {
		return this._quiz;
	}

    /**
     * Setter personne
     * @param {Personne } value
     */
	public set personne(value: Personne ) {
		this._personne = value;
	}

    /**
     * Setter quiz
     * @param {Quiz } value
     */
	public set quiz(value: Quiz ) {
		this._quiz = value;
	}

}

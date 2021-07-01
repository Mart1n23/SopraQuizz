import { ScoreKey } from './score-key';

export class Score {
  constructor(
    private _scoreKey: ScoreKey | any =null,
    private _value: number =0
  ) {}


    /**
     * Getter scoreKey
     * @return {ScoreKey }
     */
	public get scoreKey(): ScoreKey  {
		return this._scoreKey;
	}

    /**
     * Getter value
     * @return {number }
     */
	public get value(): number  {
		return this._value;
	}

    /**
     * Setter scoreKey
     * @param {ScoreKey } value
     */
	public set scoreKey(value: ScoreKey ) {
		this._scoreKey = value;
	}

    /**
     * Setter value
     * @param {number } value
     */
	public set value(value: number ) {
		this._value = value;
	}

}
